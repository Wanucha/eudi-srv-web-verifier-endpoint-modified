package eu.europa.ec.eudi.verifier.endpoint.service

import eu.europa.ec.eudi.verifier.endpoint.service.dto.AccessTokenDto
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class AccessTokenServiceImpl(
    private val webClient: WebClient
): AccessTokenService {
    override fun getAccessToken(): Mono<AccessTokenDto> {
        return webClient.post()
            .uri("https://login.fat.sparkasse.at/sts/oauth/token?clientId=transactionapp&user=207720605&scopeVariant=default")
            .contentType(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus({ it.isError }) { clientResponse ->
                Mono.error(RuntimeException("Error occurred: ${clientResponse.statusCode()}"))
            }
            .bodyToMono(AccessTokenDto::class.java)
    }
}
