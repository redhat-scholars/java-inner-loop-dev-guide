/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.snowdrop.example.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/setup")
public class SetupController {

    private static Integer DELAY_IN_MILLISECONDS = 0;
    private static Boolean THROW_ERRORS = false;

    public SetupController() {
    }

    @GetMapping("/delay/{delayInMilliseconds}")
    public String delay(@PathVariable("delayInMilliseconds") Integer delayInMilliseconds) {
        if (delayInMilliseconds < 0 || delayInMilliseconds > 30*1000) {
            return "DELAY_IN_MILLISECONDS argument must be >= 0 and <= 30000";
        }
        DELAY_IN_MILLISECONDS = delayInMilliseconds;        

        return "DELAY_IN_MILLISECONDS set to " + DELAY_IN_MILLISECONDS + " for " + System.getenv("HOSTNAME");
    }

    @GetMapping("/fix/error")
    public String fixError() {
        THROW_ERRORS = false;

        return "THROW_ERRORS set to false";
    }

    @GetMapping("/fix/delay")
    public String fixDelay() {
        DELAY_IN_MILLISECONDS = 0;        

        return "DELAY_IN_MILLISECONDS fixed";
    }

    @GetMapping("/error")
    public String error() {
        THROW_ERRORS = true;

        return "THROW_ERRORS set true for " + System.getenv("HOSTNAME");
    }

    public static Integer getDelayInMilliseconds() {
        return DELAY_IN_MILLISECONDS;
    }

    public static Boolean getThrowErrors() {
        return THROW_ERRORS;
    }
}
