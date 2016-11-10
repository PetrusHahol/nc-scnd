package com.web.command.enums;

import com.web.command.ActionCommand;
import com.web.command.MainCommand;
import com.web.command.RegistrationCommand;
import com.web.command.SignInCommand;

import javax.servlet.Registration;

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
