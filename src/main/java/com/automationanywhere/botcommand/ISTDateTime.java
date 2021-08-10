package com.automationanywhere.botcommand;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.VariableExecute;
import com.automationanywhere.commandsdk.model.DataType;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@com.automationanywhere.commandsdk.annotations.BotCommand(commandType = BotCommand.CommandType.Variable)
@CommandPkg(description = "Current IST Date Time formatted as: MM-dd-yyyy_HH-mm-ss-SSS", name = "FormattedDate", label = "Current IST DateTime String", variable_return_type = DataType.STRING)
public class ISTDateTime {
    @VariableExecute
    public StringValue formattedDate() {
        try{
            Instant instant = Instant.now();
            String zoneID = "Asia/Kolkata";
            ZonedDateTime dateTime = instant.atZone(ZoneId.of(zoneID));

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy_HH-mm-ss-SSS");
            String formattedString = formatter.format(dateTime);
            return new StringValue(formattedString);

        }catch (Exception e) {
            throw new BotCommandException("Error occurred during DateTime conversion. Error: " + e.toString());
        }

    }

}