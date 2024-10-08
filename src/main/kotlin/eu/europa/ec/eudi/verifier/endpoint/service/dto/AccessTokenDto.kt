package eu.europa.ec.eudi.verifier.endpoint.service.dto

data class AccessTokenDto(
    val accessToken: String,
    val expiresIn: Int,
    val tokenType: String,
    val scope: String,
    val journalSession: String,
)
