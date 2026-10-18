package dev.loopclient.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

/** Мелкие помощники для рисования. */
public final class Ui {
    public static final MinecraftClient mc = MinecraftClient.getInstance();

    public static final int WHITE = 0xFFFFFFFF;
    public static final int GRAY = 0xFF9A9AA4;
    public static final int DIM = 0xFF65656E;
    public static final int PANEL = 0xF0121216;
    public static final int PANEL_2 = 0xFF17171C;
    public static final int ACCENT = 0xFFFFFFFF;
    public static final int OK = 0xFF7EE2A8;
    public static final int BAD = 0xFFF87171;

    private Ui() {}

    public static void rect(DrawContext ctx, int x, int y, int w, int h, int color) {
        ctx.fill(x, y, x + w, y + h, color);
    }

    public static void text(DrawContext ctx, String s, int x, int y, int color) {
        ctx.drawText(mc.textRenderer, s, x, y, color, true);
    }

    public static int width(String s) {
        return mc.textRenderer.getWidth(s);
    }

    public static String trim(String s, int maxWidth) {
        if (width(s) <= maxWidth) return s;
        String out = s;
        while (out.length() > 1 && width(out + "…") > maxWidth) {
            out = out.substring(0, out.length() - 1);
        }
        return out + "…";
    }

    public static String duration(int ticks) {
        int seconds = ticks / 20;
        int m = seconds / 60;
        int s = seconds % 60;
        return m > 0 ? m + "м " + s + "с" : s + "с";
    }
}
