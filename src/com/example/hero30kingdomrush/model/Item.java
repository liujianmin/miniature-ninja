package com.example.hero30kingdomrush.model;

/**
 * 道具
 * @author gb
 * 网上某一牛人写的道具系统
 *
 */

public class Item {
	  public String name; //名称
	  public String dis; //描述
	  public int num=1;//数量
	  public int id; //物品_技能ID
	  public byte type; //类型（可装备的（武器，衣服，帽子，配饰），不可装备的（药），技能）
	  public byte level; //物品_技能 装备等级；
	  public short price; //物品价格（卖出。买进为卖出的300％）

	  public short addAtt; //增加的攻击力
	  public short addDef; //增加的防御

	  public short addHp_Max; //增加的HP上限
	  public short addMp_Max; //增加的MP上限
	  
	  public short addHp; //回复的HP
	  public short addMp; //MP回复
	  
	  public final void copyItem(Item item){
		  id=item.id; //物品_技能ID
		  name=item.name; //名称
		  dis=item.dis; //描述
		  num=item.num;//数量
		  type=item.type; //类型（可装备的（武器，衣服，帽子，配饰），不可装备的（药），技能）

		  level=item.level; //物品_技能 装备等级；
		  price=item.price; //物品价格（卖出。买进为卖出的300％）

		  addAtt=item.addAtt; //增加的攻击力
		  addDef=item.addDef; //增加的防御

		  addHp_Max=item.addHp_Max; //增加的HP上限
		  addMp_Max=item.addMp_Max; //增加的MP上限
		  
		  addHp=item.addHp; //回复的HP
		  addMp=item.addMp; //MP回复
	  }

//	  public Item(int ID, String n, String ds, int itemType, int itemprice, int lev,
//	                  int add_att, int add_def,int add_hp_max, int add_hp,
//	                  int add_mp) {
//	    id = (byte) ID;
//	    name = n;
//	    dis = ds;
//	    type = (byte) itemType;
//	    price = (short) itemprice;
//	    level = (byte) lev;
//	    addAtt = (short) add_att;
//	    addDef = (short) add_def;
//	    addHp_Max = (short) add_hp_max;
//	    addHp = (short) add_hp;
//	    addMp = (short) add_mp;
//	  }
}