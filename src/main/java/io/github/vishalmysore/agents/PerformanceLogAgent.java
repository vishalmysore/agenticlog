package io.github.vishalmysore.agents;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import com.t4a.annotations.Prompt;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Agent(groupName = "Performance related alerts", groupDescription = "Handling the log events related to performance issues")
public class PerformanceLogAgent {

    @Action(description = "Analyze the performance issue and suggest a solution")
    public String analyzePerformanceIssue(@Prompt(describe = "API latency details") String apiDetails) {
        log.info("Performance issue detected: {}. Suggest scaling resources.", apiDetails);
        return "Performance issue detected: " + apiDetails + ". Suggest scaling resources.";
    }

}
