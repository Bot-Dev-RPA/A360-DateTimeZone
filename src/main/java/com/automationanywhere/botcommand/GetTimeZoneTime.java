package com.automationanywhere.botcommand;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;


import com.automationanywhere.botcommand.data.impl.DateTimeValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;
import com.automationanywhere.commandsdk.model.AttributeType;

import static com.automationanywhere.commandsdk.model.DataType.*;

@BotCommand


@CommandPkg(
        name = "LHGH_TimeZone",
        label = "[[GetTimeZoneTime.label]]",
        description = "[[GetTimeZoneTime.description]]",
        node_label = "[[GetTimeZoneTime.node_label]]",
        icon = "pkg.svg",
        return_label = "[[GetTimeZoneTime.return_label]]", return_type = DATETIME, return_required = true)


public class GetTimeZoneTime {

    @Execute
    public DateTimeValue getDateTimeZone(
         @Idx(
                    index = "1", type = AttributeType.SELECT, options = {

                    //Check the index of options. TO make them child we add a "." after parent index and start the indexing from 1.
                    @Idx.Option(index = "1.1", pkg = @Pkg(label = "Asia/Kolkata", value = "Asia/Kolkata")),
                    @Idx.Option(index = "1.2", pkg = @Pkg(label = "America/New_York", value = "America/New_York")),
                    @Idx.Option(index = "1.3", pkg = @Pkg(label = "Asia/Hong_Kong", value = "Asia/Hong_Kong")),
                    @Idx.Option(index = "1.4", pkg = @Pkg(label = "Poland", value = "Poland")),
                    @Idx.Option(index = "1.5", pkg = @Pkg(label = "US/Pacific", value = "US/Pacific")),
                    @Idx.Option(index = "1.6", pkg = @Pkg(label = "US/Eastern", value = "US/Eastern")),
                    @Idx.Option(index = "1.7", pkg = @Pkg(label = "US/Central", value = "US/Central")),
                    @Idx.Option(index = "1.8", pkg = @Pkg(label = "Australia/Sydney", value = "Australia/Sydney")),
                    @Idx.Option(index = "1.9", pkg = @Pkg(label = "Europe/London", value = "Europe/London"))
                    }
            )

         @Pkg(label = "Get current time at region", default_value = "Asia/Kolkata", default_value_type = STRING)
         @NotEmpty
         String zoneID) {
        try{
            Instant instant = Instant.now();
            ZonedDateTime now = instant.atZone(ZoneId.of(zoneID));
            return new DateTimeValue(now);

        }catch (Exception e) {
            throw new BotCommandException("Error occurred during DateTime conversion. Error code: " + e.toString());
        }

    }
}
