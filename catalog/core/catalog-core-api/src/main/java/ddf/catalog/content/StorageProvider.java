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
package ddf.catalog.content;

import ddf.catalog.content.operation.CreateStorageRequest;
import ddf.catalog.content.operation.CreateStorageResponse;
import ddf.catalog.content.operation.DeleteStorageRequest;
import ddf.catalog.content.operation.DeleteStorageResponse;
import ddf.catalog.content.operation.ReadStorageRequest;
import ddf.catalog.content.operation.ReadStorageResponse;
import ddf.catalog.content.operation.UpdateStorageRequest;
import ddf.catalog.content.operation.UpdateStorageResponse;

/**
 * Provider of content repository storage.
 * <p>
 * <b> This code is experimental. While this interface is functional and tested, it may change or be
 * removed in a future version of the library. </b>
 * </p>
 */
public interface StorageProvider {

    String CONTENT_URI_PREFIX = "content";

    /**
     * Creates an item in the content repository.
     *
     * @param createStorageRequest the {@link CreateStorageRequest} that contains the {@link ddf.catalog.content.data.ContentItem} to be
     *                      stored/created in the content repository. The ID of the {@link ddf.catalog.content.data.ContentItem} will
     *                      be auto-generated by the StorageProvider.
     * @return the {@link CreateStorageResponse} that contains the {@link ddf.catalog.content.data.ContentItem} created by the
     * StorageProvider in the content repository. This {@link ddf.catalog.content.data.ContentItem} will contain the
     * GUID assigned by the StorageProvider. This GUID will be used in subsequent
     * {@link UpdateStorageRequest}, {@link ReadStorageRequest}, and {@link DeleteStorageRequest} to access the
     * stored {@link ddf.catalog.content.data.ContentItem}.
     * @throws StorageException if any problems encountered while creating/storing the {@link ddf.catalog.content.data.ContentItem}
     */
    CreateStorageResponse create(CreateStorageRequest createStorageRequest) throws StorageException;

    /**
     * Retrieves a {@link ddf.catalog.content.data.ContentItem} from the content repository.
     *
     * @param readRequest the {@link ReadStorageRequest} that contains the GUID of the {@link ddf.catalog.content.data.ContentItem} to be
     *                    retrieved
     * @return the {@link ReadStorageResponse} that contains the {@link ddf.catalog.content.data.ContentItem} retrieved by the
     * StorageProvider from the content repository.
     * @throws StorageException if any problems encountered while retrieving the {@link ddf.catalog.content.data.ContentItem}
     */
    ReadStorageResponse read(ReadStorageRequest readRequest) throws StorageException;

    /**
     * Updates a {@link ddf.catalog.content.data.ContentItem} in the content repository. The {@link ddf.catalog.content.data.ContentItem} must already
     * exist in the content repository in order to be updated. The StorageProvider will not
     * automatically create the {@link ddf.catalog.content.data.ContentItem} if it does not exist.
     *
     * @param updateStorageRequest the {@link UpdateStorageRequest} that contains the GUID of the {@link ddf.catalog.content.data.ContentItem} to be
     *                      updated and the {@link java.io.InputStream} with the new data to overwrite the existing
     *                      {@link ddf.catalog.content.data.ContentItem} in the content repository.
     * @return the {@link UpdateStorageResponse} that contains the {@link ddf.catalog.content.data.ContentItem} updated by the
     * StorageProvider in the content repository.
     * @throws StorageException if any problems encountered while updating the {@link ddf.catalog.content.data.ContentItem}
     */
    UpdateStorageResponse update(UpdateStorageRequest updateStorageRequest) throws StorageException;

    /**
     * Deletes a {@link ddf.catalog.content.data.ContentItem} from the content repository.
     *
     * @param deleteRequest the {@link DeleteStorageRequest} that contains the GUID of the {@link ddf.catalog.content.data.ContentItem} to be
     *                      deleted.
     * @return the {@link DeleteStorageResponse} that contains the status of the deletion of the
     * {@link ddf.catalog.content.data.ContentItem} from the content repository.
     * @throws StorageException if any problems encountered while deleting the {@link ddf.catalog.content.data.ContentItem}
     */
    DeleteStorageResponse delete(DeleteStorageRequest deleteRequest) throws StorageException;

    /**
     * Commit will be called by the {@link ddf.catalog.CatalogFramework} to finalize create, update, and delete requests.
     *
     * @param id the id associated with the request
     * @throws StorageException
     */
    void commit(String id) throws StorageException;

    /**
     * Dispose will be called by the {@link ddf.catalog.CatalogFramework} to discard changes related to create, update, and delete requests
     *
     * @param id the id associated with the request
     * @throws StorageException
     */
    void rollback(String id) throws StorageException;
}
