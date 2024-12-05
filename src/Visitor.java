import java.util.Objects;

public class Visitor extends Person {
    private boolean isVIP;  // 标记该游客是否为VIP
    private int visitorID;  // 游客的唯一ID

    // 构造函数
    public Visitor(String name, int age, String address, boolean isVIP, int visitorID) {
        super(name, age, address);  // 调用父类构造函数初始化名字、年龄和地址
        this.isVIP = isVIP;
        this.visitorID = visitorID;
    }

    // Getter 和 Setter 方法
    public boolean getIsVIP() {
        return isVIP;
    }

    public void setIsVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    // 重写 toString 方法，方便输出游客信息
    @Override
    public String toString() {
        return String.format("Visitor{name='%s', age=%d, address='%s', isVIP=%b, visitorID=%d}",
                getName(), getAge(), getAddress(), isVIP, visitorID);
    }

    // 重写 equals 方法，确保按 visitorID 比较游客
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  // 如果是同一个对象，直接返回 true
        if (obj == null || getClass() != obj.getClass()) return false;  // 空对象或者类型不匹配返回 false
        Visitor visitor = (Visitor) obj;  // 强制转换为 Visitor 类
        return visitorID == visitor.visitorID;  // 根据 visitorID 比较
    }

    // 重写 hashCode 方法，使其与 equals 一致
    @Override
    public int hashCode() {
        return Objects.hash(visitorID);  // 使用 visitorID 生成唯一的哈希码
    }

    // 判断游客是否为VIP
    public boolean isVIP() {
        return this.isVIP;  // 返回游客的 VIP 状态
    }
}
