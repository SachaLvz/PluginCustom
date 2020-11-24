package fr.kinstone.spawners.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.Random;

public class StringUtils
{
  public static String LINE = ChatColor.STRIKETHROUGH + "-----------------------------------------------------";
  
  public static String color(String message)
  {
    return ChatColor.translateAlternateColorCodes('&', message);
  }

}
