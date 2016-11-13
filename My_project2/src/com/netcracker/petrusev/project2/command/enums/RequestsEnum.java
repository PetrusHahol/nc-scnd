package com.netcracker.petrusev.project2.command.enums;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.command.MainCommand;
import com.netcracker.petrusev.project2.command.RegistrationCommand;
import com.netcracker.petrusev.project2.command.SignInCommand;

/**
 * Created by Asus on 10.11.2016.
 */
public enum RequestsEnum {
    SIGNIN {
        {
            this.command = new SignInCommand();
        }
    },

    MAIN {
        {
            this.command = new MainCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
