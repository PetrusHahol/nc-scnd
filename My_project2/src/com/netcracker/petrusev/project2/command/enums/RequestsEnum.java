package com.netcracker.petrusev.project2.command.enums;

import com.netcracker.petrusev.project2.command.*;
import com.netcracker.petrusev.project2.command.commands.LogOutCommand;
import com.netcracker.petrusev.project2.command.commands.MainCommand;
import com.netcracker.petrusev.project2.command.commands.RegistrationCommand;
import com.netcracker.petrusev.project2.command.commands.SignInCommand;

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
    },
    LOGOUT{
        {
            this.command = new LogOutCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
