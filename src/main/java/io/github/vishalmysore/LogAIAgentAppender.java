package io.github.vishalmysore;

import com.t4a.processor.AIProcessingException;
import com.t4a.processor.OpenAiActionProcessor;
import lombok.extern.java.Log;
import org.apache.logging.log4j.*;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.classic.spi.ILoggingEvent;


@Log
public class LogAIAgentAppender extends AppenderBase<ILoggingEvent> {

    public LogAIAgentAppender() {
        log.info("LogAIAgentAppender created");
    }
    @Override
    protected void append(ILoggingEvent eventObject) {
        // You can check for log level and message type
        if (eventObject.getLevel().toString().equals("ERROR") && eventObject.getMessage().contains("customer-support")) {

            // Extract relevant information from the log message
            OpenAiActionProcessor processor = new OpenAiActionProcessor();
            try {
                processor.processSingleAction(eventObject.getMessage());
            } catch (AIProcessingException e) {
                log.severe("Failed to process AI action: " + e.getMessage());
            }
        }
    }
}