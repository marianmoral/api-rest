package com.proyecto.arte.message;

import com.proyecto.arte.model.Resonancia;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter @Setter @AllArgsConstructor
public class ResponseMessage {
  private String message;
  private Resonancia resonancia;

  public ResponseMessage(String message) {
    this.message = message;
  }
}
