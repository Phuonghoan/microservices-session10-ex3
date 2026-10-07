package org.example.inventoryservice.consumer;

import org.example.inventoryservice.event.OrderEvent;
import org.example.inventoryservice.service.InventoryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

    private final InventoryService inventoryService;

    public OrderEventConsumer(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "medicine-stock-events")
    public void consumeOrderEvent(OrderEvent event) {

        System.out.println("Đã nhận OrderEvent từ Kafka:");
        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Medicine ID: " + event.getMedicineId());
        System.out.println("Quantity: " + event.getQuantity());

        inventoryService.decreaseStock(event);
    }
}
