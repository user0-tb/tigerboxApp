package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {
    private final BaseGraph<N> graph;
    @CheckForNull
    N node;
    private final Iterator<N> nodeIterator;
    Iterator<N> successorIterator;

    /* renamed from: of */
    static <N> EndpointPairIterator<N> m376of(BaseGraph<N> baseGraph) {
        return baseGraph.isDirected() ? new Directed(baseGraph) : new Undirected(baseGraph);
    }

    private EndpointPairIterator(BaseGraph<N> baseGraph) {
        this.node = null;
        this.successorIterator = ImmutableSet.m308of().iterator();
        this.graph = baseGraph;
        this.nodeIterator = baseGraph.nodes().iterator();
    }

    /* access modifiers changed from: package-private */
    public final boolean advance() {
        Preconditions.checkState(!this.successorIterator.hasNext());
        if (!this.nodeIterator.hasNext()) {
            return false;
        }
        N next = this.nodeIterator.next();
        this.node = next;
        this.successorIterator = this.graph.successors(next).iterator();
        return true;
    }

    private static final class Directed<N> extends EndpointPairIterator<N> {
        private Directed(BaseGraph<N> baseGraph) {
            super(baseGraph);
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public EndpointPair<N> computeNext() {
            while (!this.successorIterator.hasNext()) {
                if (!advance()) {
                    return (EndpointPair) endOfData();
                }
            }
            Object obj = this.node;
            Objects.requireNonNull(obj);
            return EndpointPair.ordered(obj, this.successorIterator.next());
        }
    }

    private static final class Undirected<N> extends EndpointPairIterator<N> {
        @CheckForNull
        private Set<N> visitedNodes;

        private Undirected(BaseGraph<N> baseGraph) {
            super(baseGraph);
            this.visitedNodes = Sets.newHashSetWithExpectedSize(baseGraph.nodes().size() + 1);
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        public EndpointPair<N> computeNext() {
            do {
                Objects.requireNonNull(this.visitedNodes);
                while (this.successorIterator.hasNext()) {
                    Object next = this.successorIterator.next();
                    if (!this.visitedNodes.contains(next)) {
                        Object obj = this.node;
                        Objects.requireNonNull(obj);
                        return EndpointPair.unordered(obj, next);
                    }
                }
                this.visitedNodes.add(this.node);
            } while (advance());
            this.visitedNodes = null;
            return (EndpointPair) endOfData();
        }
    }
}
