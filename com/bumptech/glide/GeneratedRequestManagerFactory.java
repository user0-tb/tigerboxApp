package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import media.tiger.tigerbox.infrastructure.GlideRequests;

final class GeneratedRequestManagerFactory implements RequestManagerRetriever.RequestManagerFactory {
    GeneratedRequestManagerFactory() {
    }

    public RequestManager build(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        return new GlideRequests(glide, lifecycle, requestManagerTreeNode, context);
    }
}
