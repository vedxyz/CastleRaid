package xyz.vedat.castleraid.classes;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Builder extends CastleRaidClass {
  
  private static final int PRICE = 750;
  private static final int MAX_HP = 40;
  
  public Builder() {
    
    super(PRICE, MAX_HP);
    
  }
  
  @Override
  public HashMap<Integer, ItemStack> getClassItems() {
    
    items.put(0, ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.IRON_PICKAXE )
      .setItemName(ChatColor.RED + getClass().getSimpleName() + "'s Pickaxe")
      .setItemLore("Trusty pickaxe of a builder.")
      .setUnbreakable(true)
    ));
    
    items.put(1, ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.WOOD_SWORD )
      .setItemName(ChatColor.RED + getClass().getSimpleName() + "'s Sword")
      .setItemLore("Trusty sword of a builder.")
      .setUnbreakable(true)
    ));
    
    items.put(2, ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.STONE )
      .setAmount(50)
      .setItemName(ChatColor.RED + getClass().getSimpleName() + "'s Stone Blocks")
      .setItemLore("Trusty STONE of a builder.")
    ));
    
    items.put(3, ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.WOOD_PLATE )
      .setAmount(3)
      .setItemName(ChatColor.RED + getClass().getSimpleName() + "'s Claymore")
      .setItemLore("Trusty claymore of a builder.")
    ));
    
    items.put(4, ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.STONE_PLATE )
      .setAmount(3)
      .setItemName(ChatColor.RED + getClass().getSimpleName() + "'s Toxic Cloud Trap")
      .setItemLore("Trusty toxic trap of a builder.")
    ));
    
    setBoots(ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.LEATHER_BOOTS )
      .setItemName(ChatColor.RED + getClass().getSimpleName() + "'s Boots")
      .setUnbreakable(true)
    ));
    
    setLeggings(ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.LEATHER_LEGGINGS )
      .setItemName(ChatColor.RED + getClass().getSimpleName() + "'s Leggings")
      .setUnbreakable(true)
    ));
    
    setChestplate(ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.LEATHER_CHESTPLATE )
      .setItemName(ChatColor.RED + getClass().getSimpleName() + "'s Chestplate")
      .setUnbreakable(true)
    ));
    
    return items;
    
  }
  
  public ItemStack getClassSymbolItem() {
    
    return ClassItemFactory.getBuiltItem(
      new ClassItemFactory.ClassItemData( Material.IRON_PICKAXE )
      .setItemName(ChatColor.RED + getClass().getSimpleName())
      .setItemLore(PRICE + " coins.", "Description of class.")
    );
    
  }
  
}