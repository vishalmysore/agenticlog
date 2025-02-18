package io.github.vishalmysore;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import com.t4a.processor.AIProcessingException;
import com.t4a.processor.OpenAiActionProcessor;
import lombok.extern.slf4j.Slf4j;

/**
 * This class is a custom Logback appender that listens for log messages and processes them using the Tools4AI.
 * You can filter out based on logging level and message type.
 */
@Slf4j
public class MultiLogAIAgentAppender extends AppenderBase<ILoggingEvent> {
    public MultiLogAIAgentAppender() {
        log.info("LogAIAgentAppender created");
    }
    @Override
    protected void append(ILoggingEvent eventObject) {
        // You can check for log level and message type
        if (eventObject.getLevel().toString().equals("ERROR") ) {

            // Extract relevant information from the log message
            OpenAiActionProcessor processor = new OpenAiActionProcessor();
            try {
                processor.processSingleAction(eventObject.getMessage());
            } catch (AIProcessingException e) {
                log.error("Failed to process AI action: " + e.getMessage());
            }
        }
    }
}