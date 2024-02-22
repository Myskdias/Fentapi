package com.myskdias.api.test;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class Logger {

	private static Logger instance;

	private final CommandSender sender;
	private boolean enableTrace = true;
	private String name;

	private String color ="§e";

	public Logger() {
		this("");
	}

	public Logger(String name) {
		this.name = name;
		this.sender = Bukkit.getConsoleSender();
	}

	public static Logger getInstance() {
		return instance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static void setInstance(Logger logger)  {
		instance = logger;
	}

	public Logger enableTrace(boolean b) {
		this.enableTrace = b;
		return this;
	}

	public void debug(String message) {
		if(enableTrace) {
			sender.sendMessage(f(name)+color+message);
		}
	}

	public void warn(String message) {
		if(enableTrace) {
			sender.sendMessage(f(name)+"§2"+message);
		}
	}

	public void info(String msg) {
		if(enableTrace) {
			sender.sendMessage(f(name)+"§6"+msg);
		}
	}

	public void error(String message) {
		if(enableTrace) {
			sender.sendMessage(f(name)+"§4"+message);
		}
	}

	private String f(String name) {
		return "§b[§a"+name+"§b]§r ";
	}


	public void error(String string, Exception e) {
		error(string);
		if(enableTrace) {
			e.printStackTrace();
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isEnableTrace() {
		return enableTrace;
	}

}
