// ------------------------------------------------------------------------------
// Copyright (c) 2015 Microsoft Corporation
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
// ------------------------------------------------------------------------------

// **NOTE** This file was generated by a tool and any changes will be overwritten.
package com.onedrive.sdk.generated;

import com.onedrive.sdk.concurrency.*;
import com.onedrive.sdk.core.*;
import com.onedrive.sdk.extensions.*;
import com.onedrive.sdk.http.*;
import com.onedrive.sdk.generated.*;
import com.onedrive.sdk.options.*;
import com.onedrive.sdk.serializer.*;

import java.util.*;

// **NOTE** This file was generated by a tool and any changes will be overwritten.

/**
 * The class for the Base Thumbnail Set Collection Request.
 */
public class BaseThumbnailSetCollectionRequest extends BaseCollectionRequest<BaseThumbnailSetCollectionResponse, IThumbnailSetCollectionPage> implements IBaseThumbnailSetCollectionRequest {

    /**
     * The request builder for this collection of ThumbnailSet
     *
     * @param requestUrl The request url
     * @param client The service client
     * @param options The options for this request
     */
    public BaseThumbnailSetCollectionRequest(final String requestUrl, IOneDriveClient client, final List<Option> options) {
        super(requestUrl, client, options, BaseThumbnailSetCollectionResponse.class, IThumbnailSetCollectionPage.class);
    }

    public void get(final ICallback<IThumbnailSetCollectionPage> callback) {
        final IExecutors executors = getBaseRequest().getClient().getExecutors();
        executors.performOnBackground(new Runnable() {
           @Override
           public void run() {
                try {
                    executors.performOnForeground(get(), callback);
                } catch (final ClientException e) {
                    executors.performOnForeground(e, callback);
                }
           }
        });
    }

    public IThumbnailSetCollectionPage get() throws ClientException {
        final BaseThumbnailSetCollectionResponse response = send();
        return buildFromResponse(response);
    }

    public IThumbnailSetCollectionRequest expand(final String value) {
        addQueryOption(new QueryOption("expand", value));
        return (ThumbnailSetCollectionRequest)this;
    }

    public IThumbnailSetCollectionRequest select(final String value) {
        addQueryOption(new QueryOption("select", value));
        return (ThumbnailSetCollectionRequest)this;
    }

    public IThumbnailSetCollectionRequest top(final int value) {
        addQueryOption(new QueryOption("top", value + ""));
        return (ThumbnailSetCollectionRequest)this;
    }

    public IThumbnailSetCollectionPage buildFromResponse(final BaseThumbnailSetCollectionResponse response) {
        final IThumbnailSetCollectionRequestBuilder builder;
        if (response.nextLink != null) {
            builder = new ThumbnailSetCollectionRequestBuilder(response.nextLink, getBaseRequest().getClient(), /* options */ null);
        } else {
            builder = null;
        }
        final ThumbnailSetCollectionPage page = new ThumbnailSetCollectionPage(response, builder);
        page.setRawObject(response.getSerializer(), response.getRawObject());
        return page;
    }
}
