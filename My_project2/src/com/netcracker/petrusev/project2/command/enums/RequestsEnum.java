package com.netcracker.petrusev.project2.command.enums;

import com.netcracker.petrusev.project2.command.*;
import com.netcracker.petrusev.project2.command.commands.*;
import com.netcracker.petrusev.project2.command.commands.brigade.AddBrigadeCommand;
import com.netcracker.petrusev.project2.command.commands.brigade.DeleteBrigadeCommand;
import com.netcracker.petrusev.project2.command.commands.employee.AddEmployeeCommand;
import com.netcracker.petrusev.project2.command.commands.employee.DeleteEmployeeCommand;
import com.netcracker.petrusev.project2.command.commands.flight.AddFlightCommand;
import com.netcracker.petrusev.project2.command.commands.flight.DeleteFlightCommand;
import com.netcracker.petrusev.project2.command.commands.user.*;

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
    USERPAGECOMMAND{
        {
            this.command = new UserPageCommand();
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
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
