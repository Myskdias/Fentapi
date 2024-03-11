package com.myskdias.uhc.test;

import com.myskdias.uhc.test.exemple.Foo;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;
import org.bukkit.Bukkit;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class ByeTest {

    public static Foo tezart;

    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println(ByeTest.class.getCanonicalName());
        Class foo = magieTresNoire();

        Foo f = new Foo(); // création de l'objet
        magieNoire();
        System.out.println(f.getString()); //Appel de la fonction getString de l'objet f créer
                                        // avant la magie noire
        foo.getDeclaredField("test");
        Field field = f.getClass().getDeclaredField("test");
    }

    public static void magieNoire() {
        ByteBuddyAgent.install();
        new ByteBuddy().redefine(Foo.class)
                .method(named("getString"))
                .intercept(FixedValue.value("Il fait gris"))
                .make()
                .load(Foo.class.getClassLoader(),
                        ClassReloadingStrategy.fromInstalledAgent());
        //Magie noire
    }

    public static Class magieTresNoire() {

        TypePool typePool = TypePool.Default.ofSystemLoader();
        Class foo = new ByteBuddy()
                .redefine(typePool.describe("com.myskdias.uhc.test.exemple.Foo").resolve(), // do not use 'Bar.class'
                        ClassFileLocator.ForClassLoader.ofSystemLoader())
                .defineField("test", String.class) // we learn more about defining fields later
                .make()
                .load(ClassLoader.getSystemClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                .getLoaded();
        return foo;
    }

}
