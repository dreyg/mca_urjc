import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a city with its name and landscape"

    request {
        url "/api/topographicdetails/Barcelona"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: "Barcelona",
                landscape: "Flat"
        )
    }
}