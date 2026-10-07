package org.example.inventoryservice.service;

import org.example.inventoryservice.event.OrderEvent;
import org.example.inventoryservice.repository.MedicineRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final MedicineRepository medicineRepository;

    public InventoryService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Transactional
    public void decreaseStock(OrderEvent event) {

        int updatedRows = medicineRepository.decreaseStock(
                event.getMedicineId(),
                event.getQuantity()
        );

        if (updatedRows == 0) {
            throw new RuntimeException(
                    "Không tìm thấy thuốc có ID: " + event.getMedicineId()
            );
        }

        System.out.println(
                "Đã trừ " + event.getQuantity()
                        + " sản phẩm thuốc ID "
                        + event.getMedicineId()
        );
    }
}
