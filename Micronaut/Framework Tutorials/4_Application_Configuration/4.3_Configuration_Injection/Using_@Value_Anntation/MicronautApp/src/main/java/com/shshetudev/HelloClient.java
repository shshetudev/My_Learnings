package com.shshetudev;

import io.micronaut.http.client.annotation.Client;

@Client("${my.server.url: `http://localhost:8080`}")
interface HelloClient {
}
