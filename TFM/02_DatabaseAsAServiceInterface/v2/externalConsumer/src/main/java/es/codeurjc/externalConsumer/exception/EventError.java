package es.codeurjc.externalConsumer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EventError extends RuntimeException {
  private String message;
}
