package com.example.demo.entity;

import com.example.demo.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
class ItemTest {
    @InjectMocks
    private Item item;

    @Test
    @DisplayName("item status의 nullable=false 테스트 ")
    void ItemStatus() {

        //given
        item = new Item();

        //when


        //then

    }

  
}