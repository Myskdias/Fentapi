package com.myskdias.api.logging;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginLogger;

import java.util.logging.LogRecord;

public class CustomLogger extends PluginLogger {

    private String color = Color.DARK_CYAN.toString();
    private String severeColor = Color.DARK_RED.toString();
    private String warningColor = Color.DARK_YELLOW.toString();
    private String infoColor = null;
    private String configColor = null;
    private String fineColor = null;
    private String finerColor = null;
    private String finestColor = null;

    private static final int SEVERE = 1000;
    private static final int WARNING = 900;
    private static final int INFO = 800;
    private static final int CONFIG = 700;
    private static final int FINE = 500;
    private static final int FINER = 400;
    private static final int FINEST = 300;

    public CustomLogger(Plugin context) {
        super(context);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void log(LogRecord logRecord) {

       String color = this.color;

        switch (logRecord.getLevel().intValue()) {
            case INFO :
                if(infoColor != null) {
                    color = infoColor;
                }
                break;
            case WARNING:
                if(warningColor != null) {
                    color = warningColor;
                }
                break;
            case SEVERE:
                if(severeColor != null) {
                    color = severeColor;
                }
                break;
            case CONFIG:
                if(configColor != null) {
                    color = configColor;
                }
                break;
            case FINE:
                if(fineColor != null) {
                    color = fineColor;
                }
                break;
            case FINER:
                if(finerColor != null) {
                    color = finerColor;
                }
                break;
            case FINEST:
                if(finestColor != null) {
                    color = finestColor;
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + logRecord.getLevel());
        }
        logRecord.setMessage(logRecord.getMessage() + Color.RESET + color + Color.RESET);
        super.log(logRecord);
    }

    public String getSevereColor() {
        return severeColor;
    }

    public void setSevereColor(String severeColor) {
        this.severeColor = severeColor;
    }

    public String getWarningColor() {
        return warningColor;
    }

    public void setWarningColor(String warningColor) {
        this.warningColor = warningColor;
    }

    public String getInfoColor() {
        return infoColor;
    }

    public void setInfoColor(String infoColor) {
        this.infoColor = infoColor;
    }

    public String getConfigColor() {
        return configColor;
    }

    public void setConfigColor(String configColor) {
        this.configColor = configColor;
    }

    public String getFineColor() {
        return fineColor;
    }

    public void setFineColor(String fineColor) {
        this.fineColor = fineColor;
    }

    public String getFinerColor() {
        return finerColor;
    }

    public void setFinerColor(String finerColor) {
        this.finerColor = finerColor;
    }

    public String getFinestColor() {
        return finestColor;
    }

    public void setFinestColor(String finestColor) {
        this.finestColor = finestColor;
    }

}
