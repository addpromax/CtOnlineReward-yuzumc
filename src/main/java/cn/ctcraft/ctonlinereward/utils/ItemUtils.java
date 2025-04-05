// DeepSeek code
package cn.ctcraft.ctonlinereward.utils;

import com.cryptomorin.xseries.SkullUtils;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemUtils {
    public static ItemStack createSkull(String texture) {
        // 使用 XMaterial 自动处理跨版本材质问题
        ItemStack item = XMaterial.PLAYER_HEAD.parseItem();
        if (item == null) {
            // 如果解析失败（极端情况），使用默认材质
            item = new ItemStack(org.bukkit.Material.PLAYER_HEAD);
        }

        if (texture == null || texture.isEmpty()) {
            return item;
        }

        // 使用 SkullUtils 处理材质设置（兼容 1.20.5+ 和旧版本）
        if (item.getItemMeta() instanceof SkullMeta) {
            SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
            SkullUtils.applySkin(skullMeta, texture);
            item.setItemMeta(skullMeta);
        }
        
        return item;
    }
}
