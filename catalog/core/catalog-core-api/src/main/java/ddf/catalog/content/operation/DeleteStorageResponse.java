/**
 * Copyright (c) Codice Foundation
 * <p/>
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. A copy of the GNU Lesser General Public License
 * is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 **/
package ddf.catalog.content.operation;

import java.util.List;

import ddf.catalog.content.data.ContentItem;
import ddf.catalog.operation.Response;

/**
 * Response that holds the @{link List} of deleted {@link ContentItem}s
 * <p>
 * <b> This code is experimental. While this interface is functional and tested, it may change or be
 * removed in a future version of the library. </b>
 * </p>
 */
public interface DeleteStorageResponse extends Response<DeleteStorageRequest> {

    /**
     * Returns @{link List} of deleted {@link ContentItem}s
     *
     * @return @{link List} of deleted {@link ContentItem}s
     */
    List<ContentItem> getDeletedContentItems();

    /**
     * Returns the ID associated with the request that resulted in this response
     *
     * @return request ID
     */
    String getId();
}
