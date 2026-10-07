package org.example.inventoryservice.event;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderEvent {

    private Long orderId;

    private Long medicineId;

    private Integer quantity;

    private LocalDateTime timestamp;
}
