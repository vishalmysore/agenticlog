package io.github.vishalmysore.agents;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Agent(groupName = "No Matching Log ", groupDescription = "Should use this if no action is found")
public class NoMatchingLogAgent {

    @Action(description = "Logs that no matching log was found")
    public void logNoMatchingLog(String logLine) {
        log.info("No matching log found {}", logLine);
    }
}
