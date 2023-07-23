package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"N"})
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public abstract N source();

    public abstract N target();

    private EndpointPair(N n, N n2) {
        this.nodeU = Preconditions.checkNotNull(n);
        this.nodeV = Preconditions.checkNotNull(n2);
    }

    public static <N> EndpointPair<N> ordered(N n, N n2) {
        return new Ordered(n, n2);
    }

    public static <N> EndpointPair<N> unordered(N n, N n2) {
        return new Unordered(n2, n);
    }

    /* renamed from: of */
    static <N> EndpointPair<N> m374of(Graph<?> graph, N n, N n2) {
        return graph.isDirected() ? ordered(n, n2) : unordered(n, n2);
    }

    /* renamed from: of */
    static <N> EndpointPair<N> m375of(Network<?, ?> network, N n, N n2) {
        return network.isDirected() ? ordered(n, n2) : unordered(n, n2);
    }

    public final N nodeU() {
        return this.nodeU;
    }

    public final N nodeV() {
        return this.nodeV;
    }

    public final N adjacentNode(N n) {
        if (n.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (n.equals(this.nodeV)) {
            return this.nodeU;
        }
        String valueOf = String.valueOf(this);
        String valueOf2 = String.valueOf(n);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36 + String.valueOf(valueOf2).length());
        sb.append("EndpointPair ");
        sb.append(valueOf);
        sb.append(" does not contain node ");
        sb.append(valueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }

    private static final class Ordered<N> extends EndpointPair<N> {
        public boolean isOrdered() {
            return true;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        private Ordered(N n, N n2) {
            super(n, n2);
        }

        public N source() {
            return nodeU();
        }

        public N target() {
            return nodeV();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() == endpointPair.isOrdered() && source().equals(endpointPair.source()) && target().equals(endpointPair.target())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        public String toString() {
            String valueOf = String.valueOf(source());
            String valueOf2 = String.valueOf(target());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 6 + String.valueOf(valueOf2).length());
            sb.append("<");
            sb.append(valueOf);
            sb.append(" -> ");
            sb.append(valueOf2);
            sb.append(">");
            return sb.toString();
        }
    }

    private static final class Unordered<N> extends EndpointPair<N> {
        public boolean isOrdered() {
            return false;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return EndpointPair.super.iterator();
        }

        private Unordered(N n, N n2) {
            super(n, n2);
        }

        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            if (!nodeU().equals(endpointPair.nodeV()) || !nodeV().equals(endpointPair.nodeU())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(nodeU());
            String valueOf2 = String.valueOf(nodeV());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length());
            sb.append("[");
            sb.append(valueOf);
            sb.append(", ");
            sb.append(valueOf2);
            sb.append("]");
            return sb.toString();
        }
    }
}
