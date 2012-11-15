package com.example.hero30kingdomrush.model;

public class Role {
	public byte type;// 角色类型
	
	public String name;//角色名字
	
	public byte gender;//性别类型

	public int lev;// 等级

	public int exp;// 经验

	public int hp;// 当前生命值
	
	public int maxHp;//总生命值

	public int mp;// 魔法值

	public int ap;// 攻击力
	
	public int def; //防御力

	public int x;// 角色相对于屏幕的坐标

	public int y;

	public int speed;// 人物的步长(移动速度)

	public int roleDir;// 角色方向

	public int roleState;// 角色状态
	

	private int actionNum;// 动作的数量

	private boolean bNoAction;// 没有动作

	private RoleAction[] roleAction;// 动作数组

	public int actionID;// 当前要播放的动作ID

	public int drawType;// 绘制类型0为不镜像 1为镜像

	public int actionType;// 动作播放类型 1为播放1帧 0为播放一次 其他为循环播放
	

	public int traceArea = 50;// 角色的追踪视野范围

	public int attackArea = 25;// 角色的攻击视野

	public int attTime = 1000;// 角色的攻击时间间隔
	
	public int[][] itemFall;//角色掉落的物品和概率[i][0]物品ID [i][1]掉率
	
	public int maxMoney;//角色掉落的最多钱数
	

	private Map map;// 角色所在的地图的对象

	public Role(Map map) {// 构造函数中引入Map类对象
		this.map = map;// Role的Map类变量指向当前地图
	}

	/**
	 * 设置当前要播放的动作
	 * @param id int  动作ID
	 */
	public final void setActionID(int id, int type, int _actionType) {
		if (id >= actionNum) { //判断是否取到了没有的动作
			bNoAction = true;//没有该动作
			return;
		}
		bNoAction = false;//
		if (id != -1) {//如果==-1那么就不改变动作ID
			actionID = id;
		}
		if (type != -1) {//如果==-1那么就不改变绘制类型
			drawType = type;
		}
		if (_actionType != -1) {//如果==-1那么就不改变动作播放类型
			actionType = _actionType;
		}
	}
	
	/**
	 * 设置下一个要播放的动作
	 * @param type
	 * @param _actionType
	 */
	public final void nextAction(int type, int _actionType){
		if(++actionID>=actionNum){
			actionID=0;
		}
		
		if (type != -1) {//如果==-1那么就不改变绘制类型
			drawType = type;
		}
		if (_actionType != -1) {//如果==-1那么就不改变动作播放类型
			actionType = _actionType;
		}
	}

	/**
	 * 载入角色数据
	 */
	public final void loadRoleData(DataInputStream din) {
		try {
			din.readInt();
			actionNum = din.readByte(); //读动作数
			roleAction = new RoleAction[actionNum];
			for (int i = 0; i < actionNum; i++) {
				roleAction[i] = new RoleAction();
				roleAction[i].loadActionData(din); //载入角色动作数据
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 拷贝角色
	 * @param role Role
	 * @param m int
	 * @param n int
	 */
	public final void copyRoll(Role role, int m, int n) {
		actionNum = role.actionNum;//复制动作数
		roleAction = new RoleAction[role.actionNum];//创建动作数组
		for (int i = 0; i < actionNum; i++) {
			roleAction[i] = new RoleAction();
			roleAction[i].copyAction(role.roleAction[i]);//复制动作类对象
		}

		//复制属性
		type = role.type;
		name =role.name;
		lev = role.lev;
		exp = role.exp;
		hp = role.hp;
		maxHp = role.maxHp;
		mp = role.mp;
		ap = role.ap;
		def = role.def;

		x = n * 16;//获得相对于地图的像素坐标
		y = m * 16;
		speed = role.speed;
		actionType=role.actionType;
		gender=role.gender;
		itemFall=role.itemFall;
		maxMoney=role.maxMoney;
	}

	/**
	 * 绘制角色的方法
	 * @param g Graphics
	 */
	public final void drawRole(Graphics g, int offx, int offy) {
		if (roleAction[actionID].drawRoleAction(g, x - offx, y - offy,
				drawType, actionType)) {
			actionType = 1; //如果播放完了一次 那么就设置播放方式为播放第一帧
			roleState = Data.ROLE_STAND;//设置角色状态为站立状态
		}
	}

	/**
	 * 角色移动
	 * @param keyCode int 按键信息
	 */
	public final void roleMove(int keyCode, int type) {
		if (bNoAction) { //当取到超出动作数量时 不移动
			return;
		}
		if (type > 0) { //当一般行走时 记录当前的按键方向
			roleDir = keyCode;
		}
		
		switch (keyCode) {
		case Data.KEY_UP: // 当按上方向键时
			if (y > 10) { //角色向上超出地图边界
				y -= speed;
			}
			break;
		case Data.KEY_RIGHT: // 当按右方向键时
			if (x < map.width * map.cellWidth - 10) { //角色向右超出地图边界
				x += speed;
			}
			break;
		case Data.KEY_DOWN: // 当按下方向键时
			if (y < map.height * map.cellHeight - speed) {
				y += speed;
			}
			break;
		case Data.KEY_LEFT: // 当按左方向键时
			if (x > 10) {
				x -= speed;
			}
			break;
		}
	}

	private byte triggerNum;//本人物拥有触发事件数量（如对话数量）

	private String[] strTrigger;//保存事件的数组

	public final void setTriggerNum(byte num) {
		triggerNum = num;
		strTrigger = new String[triggerNum];
	}

	public final byte getTriggerNum() {
		return triggerNum;
	}

	private int tempIndex;

	public final void addTrigger(String str) {
		strTrigger[tempIndex] = str;
		tempIndex++;
	}

	public final String getStrTrigger(int id) {
		if (id >= triggerNum) {
			return null;
		}
		return strTrigger[id];
	}

	public final int[] getHitRect() { //取得碰撞区域
		return roleAction[actionID].getHitRect();
	}

	public final int[] getAttackRect() { //取得攻击矩形
		return roleAction[actionID].getAttackRect(drawType);
	}

	public final void setRoleState(int _state) { //设置角色状态
		roleState = _state;
	}

	public final void setIX(int x) {//设置角色X轴位置
		this.x = x;
	}

	public final void setIY(int y) {//设置角色y轴位置
		this.y = y;
	}

}
