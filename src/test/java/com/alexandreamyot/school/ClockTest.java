package com.alexandreamyot.school;

import org.junit.Test;

import java.time.*;

import static java.time.ZoneOffset.UTC;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ClockTest {

    @Test
    public void createsClockForASpecificTime() {
        Instant currentTime = LocalDateTime.of(2012, 6, 27, 12, 4, 0).toInstant(UTC);
        Clock clock = Clock.fixed(currentTime, UTC);

        assertThat(clock.instant(), equalTo(LocalDateTime.of(2012, 6, 27, 12, 4, 0).toInstant(UTC)));
    }

}
