package io.github.vishalmysore;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.t4a.processor.AIProcessingException;
import com.t4a.processor.OpenAiActionProcessor;
import io.github.vishalmysore.a2a.client.LocalA2ATaskClient;
import io.github.vishalmysore.a2a.domain.Task;
import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
public class A2ALogAppender extends AppenderBase<ILoggingEvent> {
    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    private LocalA2ATaskClient client;

    public A2ALogAppender() {
        context.scan("io.github.vishalmysore.a2a", "io.github.vishalmysore.a2a.server","io.github.vishalmysore.exec.a2a");
        context.refresh();
        log.info("LogAIAgentAppender created");
        client = context.getBean(LocalA2ATaskClient.class);
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        // You can check for log level and message type
        if (eventObject.getLevel().toString().equals("ERROR") && eventObject.getMessage().contains("customer-support")) {

            // Send task and log response
            Task t = client.sendTask(eventObject.getMessage());

            log.info(client.getTask(t.getId(),2).toString());




            // Clean up
            //context.close();

        }
    }
}