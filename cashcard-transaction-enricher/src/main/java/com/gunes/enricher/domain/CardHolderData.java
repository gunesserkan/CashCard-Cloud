package com.gunes.enricher.domain;

import java.util.UUID;

public record CardHolderData(UUID userId, String name, String address) {
}
