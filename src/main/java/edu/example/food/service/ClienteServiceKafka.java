package edu.example.food.service;

import edu.example.food.config.KafkaConfig;
import edu.example.food.dto.DTOCliente;
import edu.example.food.utilities.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.TopicPartitionOffset;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceKafka {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Flux<DTOCliente> obtenerClientesDesdeKafka(String topico) {
        ConsumerRecords<String, String> consumerRecords;
        KafkaConfig kafkaConfig = new KafkaConfig();
        kafkaTemplate.setConsumerFactory(kafkaConfig.consumerFactory());
        consumerRecords = kafkaTemplate.receive(List.of(new TopicPartitionOffset(topico, 0)));
        return convertirClientes(consumerRecords);
    }

    private Flux<DTOCliente> convertirClientes(ConsumerRecords<String, String> consumerRecords) {
        List<DTOCliente> clientes = new LinkedList<>();
        for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
            clientes.add(JsonUtil.getFromJson(consumerRecord.value(), DTOCliente.class));
        }
        return Flux.fromIterable(clientes);
    }
}
