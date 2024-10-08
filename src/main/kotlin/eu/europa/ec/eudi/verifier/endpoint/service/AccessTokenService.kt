package eu.europa.ec.eudi.verifier.endpoint.service

import eu.europa.ec.eudi.verifier.endpoint.service.dto.AccessTokenDto
import reactor.core.publisher.Mono

interface AccessTokenService {
    fun getAccessToken(): Mono<AccessTokenDto>
}
