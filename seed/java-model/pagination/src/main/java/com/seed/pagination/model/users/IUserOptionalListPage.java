/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.pagination.model.users;

import java.util.Optional;
import java.util.UUID;

public interface IUserOptionalListPage {
    UserOptionalListContainer getData();

    Optional<UUID> getNext();
}
