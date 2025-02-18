package io.github.vishalmysore.agents;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import com.t4a.annotations.Prompt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Agent(groupName = "Security Incidents", groupDescription = "Handling the log events related to security incidents")
public class SecurityLogAgent {


    @Action(description = "Escalate the security incident to the security team")
    public String escalateSecurityIncident(@Prompt(describe = "Suspicious activity detected in logs") String ipAddress) {
        log.info("Escalating security incident: {}", ipAddress);
        return "Security incident reported: " + ipAddress;
    }

}
