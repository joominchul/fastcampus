//전사, 기사, 몬스터는 체력, 공격력, 방어력이 존재하며 생존유무를 알 수 있어야 한다.
//기사는 하드어택 기능이 있고, 이 기능을 사용하기 위해서는 에너지가 3 필요하다.
//전사는 몬스터를 특정 마리 수 이상 처치하면 기사로 진화 가능.

open class warrior(name:String = "warrior"){
    open var hp:Int = 10
        set(value) {
            println(""+name+"의 체력이 "+(field - value)+"만큼 감소해 "+value+"가 되었다.")
            field = value
            DoL()
        }
    open var att:Int = 7
    open var def:Int = 7
    open var life:Boolean = true
    open val name:String
    var exp:Int = 0
    init {
        this.name = name
    }
    open fun attack(monster: monster){
        if (!monster.life) println(""+monster.name+"은 이미 죽었습니다.")
        else{
            if (life) {
                val damage:Int = att*2 - monster.def
                println("" + name + " 전사가 " + damage + "만큼 "+monster.name+"을 공격!")
                monster.hp -= damage
                if (!monster.life){
                    println(""+name+" 전사가 "+monster.name+"을 처치했다!")
                    exp+=1
                    println("경험치가 1 쌓여 "+exp+"만큼 쌓였다!")
                    if (exp>=3) println("${name}은 레벨업이 가능합니다.")

                }
            }
        }

    }
    fun DoL(){
        if(hp<=0) {
            println(""+name+"은 죽었습니다.")
            life = false
        }
        else println(""+name+"은 살아있습니다.")
    }
    fun levelup():knight{
        println(""+name+" 레벨업!!")
        return knight(this)
    }

}

class monster(name:String = "monster"){
    var hp:Int = 20
        set(value) {
            println(""+name+"의 체력이 "+(field - value)+"만큼 감소해 "+value+"가 되었다.")
            field = value
            DoL()
        }
    var att:Int = 5
    var def:Int = 5
    var life:Boolean = true
    val name:String
    init {
        this.name = name
    }
    fun attack(human:warrior){
        if (life) {
            val damage:Int = att*2 - human.def
            println("" + name + "가 " + damage + "만큼 "+human.name+"을 공격!")
            human.hp -= damage
        }

    }
    fun DoL(){
        if(hp<=0) {
            println(""+name+"은 죽었습니다.")
            life = false
        }
        else println(""+name+"은 살아있습니다.")
    }
}

class knight(war: warrior):warrior(){
    override var hp:Int = 20
        set(value) {
            field = field - value
            println(""+name+"의 체력이 "+value+"만큼 감소해 "+field+"가 되었다.")
            DoL()
        }
    override var att:Int = 10
    override var def:Int = 10
    override var name:String = war.name
    var energy:Int = 0
    fun introduce(){
        println("저는 기사 ${name}입니다.")
    }

    override fun attack(monster: monster) {
        if (!monster.life) println(""+monster.name+"은 이미 죽었습니다.")
        else{
            if (life) {
                energy+=1
                val damage:Int = att*2 - monster.def
                println("" + name + " 기사가 " + damage + "만큼 "+monster.name+"을 공격!")
                monster.hp -= damage
                if (!monster.life){
                    println(""+name+" 기사가 "+monster.name+"을 처치했다!")
//                    exp+=1
//                    println("경험치가 1 쌓여 "+exp+"만큼 쌓였다!")
//                    if (exp>=3) println("${name}은 레벨업이 가능합니다.")

                }
            }
        }

    }
    fun hardattack(monster: monster){
        if (energy >=3){
            if (!monster.life) println(""+monster.name+"은 이미 죽었습니다.")
            else{
                if (life) {
                    energy-=3
                    val damage:Int = att*3 - monster.def
                    println("하드 어택!!")
                    println("" + name + " 기사가 " + damage + "만큼 "+monster.name+"을 공격!")
                    monster.hp -= damage
                    if (!monster.life){
                        println(""+name+" 기사가 "+monster.name+"을 처치했다!")
//                        exp+=1
//                        println("경험치가 1 쌓여 "+exp+"만큼 쌓였다!")
//                        if (exp>=3) println("${name}은 레벨업이 가능합니다.")

                    }
                }
            }
        }
        else println("에너지가 부족합니다. 현재 에너지양 : ${energy}")
    }
}
var w = warrior("joo")
val m = monster("tiger")

w.attack(m)
m.attack(w)
w.attack(m)
m.attack(w)
w.attack(m)
m.attack(w)
w.attack(m)
val m1 = monster("lion")
w.attack(m1)
m1.attack(w)
w.attack(m1)
w.attack(m1)
val m2 = monster("wolf")
w.attack(m2)
w.attack(m2)
w.attack(m2)
var k = w.levelup()
k.introduce()
val m3 = monster("dragon")
k.hardattack(m3)
k.attack(m3)
k.attack(m3)
val m4 = monster("giant")
k.attack(m4)
k.hardattack(m4)



