package io.github.vishalmysore;


import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import com.t4a.annotations.Prompt;

@Agent(groupName = "Customer Support", groupDescription = "Handling the log events related to customer queries")
public class LogHandlingAgent {

    // Action to create a support ticket based on log entry
    @Action(description = "Create a support ticket for a customer")
    public String createSupportTicket(
            @Prompt(describe = "Customer ID extracted from the log") String customerId,
            @Prompt(describe = "Customer query or issue from the log") String query) {

        // Logic to create a support ticket
        return "Support ticket created for customer " + customerId + " with query: " + query;
    }

    // Action to escalate an issue based on error level in log
    @Action(description = "Escalate a high priority issue")
    public String escalateIssue(@Prompt(describe = "The error message or severity") String errorMessage) {
        // Logic to escalate the issue
        return "Issue escalated due to severity: " + errorMessage;
    }
}

