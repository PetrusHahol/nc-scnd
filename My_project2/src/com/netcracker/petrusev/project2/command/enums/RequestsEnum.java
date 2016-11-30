package com.netcracker.petrusev.project2.command.enums;

import com.netcracker.petrusev.project2.command.*;
import com.netcracker.petrusev.project2.command.commands.*;
import com.netcracker.petrusev.project2.command.commands.brigade.AddBrigadeCommand;
import com.netcracker.petrusev.project2.command.commands.brigade.DeleteBrigadeCommand;
import com.netcracker.petrusev.project2.command.commands.employee.AddEmployeeCommand;
import com.netcracker.petrusev.project2.command.commands.employee.DeleteEmployeeCommand;
import com.netcracker.petrusev.project2.command.commands.flight.AddFlightCommand;
import com.netcracker.petrusev.project2.command.commands.flight.DeleteFlightCommand;
import com.netcracker.petrusev.project2.command.commands.flight.UpdateFlightCommand;
import com.netcracker.petrusev.project2.command.commands.locale.SetLanguage;
import com.netcracker.petrusev.project2.command.commands.user.*;

/**
 * @author Petrusev
 * @version 1.0
 *
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
    },
    DELETEUSER{
        {
            this.command = new DeleteUserCommand();
        }
    },
    ADDFLIGHT{
        {
            this.command = new AddFlightCommand();
        }
    },
    DELETEFLIGHT{
        {
            this.command = new DeleteFlightCommand();
        }
    },
    GETUSERPAGECOMMAND{
        {
            this.command = new GetUserPageCommand();
        }
    },
    ADDEMPLOYEE{
        {
            this.command = new AddEmployeeCommand();
        }
    },
    DELETEEMPLOYEE{
        {
            this.command = new DeleteEmployeeCommand();
        }
    },
    ADDBRIGADE{
        {
            this.command = new AddBrigadeCommand();
        }
    },
    DELETEBRIGADE{
        {
            this.command = new DeleteBrigadeCommand();
        }
    },
    ACCESSEXCEPTION {
        {
            this.command = new GetAccessExceptionCommand();
        }
    },
    UPDATEFLIGHT{
        {
            this.command = new UpdateFlightCommand();
        }
    },
    SETLOCALE{
        {
            this.command = new SetLanguage();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
