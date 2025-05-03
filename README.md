# ToolsJS
A [KubeJS](https://kubejs.com) addon for creating tools! Any type of tools! Includes all tools and features of [CucumberJS](https://git.bluemethyst.dev/CucumberJS), PaxelJS and lots of new ones!

## Dependencies
[Kotlin for Forge](https://modrinth.com/mod/kotlin-for-forge)

[KubeJS](https://modrinth.com/mod/kubejs/)

[Ex Deorum](https://modrinth.com/mod/ex-deorum/) (Optional, if you plan to use tools from that mod)

## Usage
```js
StartupEvents.registry("item", (event) => {
    event.create("test_hammer", "exdeorum:hammer").tag("exdeorum:hammers");
    event.create("test_crook", "exdeorum:crook").tag("exdeorum:crooks");
    event.create("test_mesh", "exdeorum:mesh");
    event.create("test_wateringcan", "exdeorum:watering_can").capacity(3000); //capacity not working
    event.create("test_brush", "brush");
    event.create("test_shield", "shield");
    event.create("test_paxel", "paxel");
    event.create("test_bow", "bow");
    event.create("test_crossbow", "crossbow");
    event.create("fishing_rod", "fishing_rod");
});
```
You can also use built in textures to help create your tools quickly. This one will make the paxel head a different colour.
View the built-in textures [here](/src/main/resources/assets/toolsjs/textures/item)
```js
StartupEvents.registry("item", (event) => {
    event
        .create("test_paxel", "paxel")
        .texture("layer0", "toolsjs:item/paxel_handle")
        .texture("layer1", "toolsjs:item/paxel")
        .color(1, 0x74c7ec);
});
```
![img.png](.github/assets/custom_paxel.png)

An example of horse armor with the diamond item texture and armor texture.
```js
StartupEvents.registry("item", (event) => {
    event
        .create("test_horse_armor", "horse_armor")
        .material("diamond")
        .armorTexture(
            "minecraft:textures/entity/horse/armor/horse_armor_diamond"
        )
        .texture("minecraft:item/diamond_horse_armor");
});

```

Here is an example of a custom crossbow with a custom texture. 
You need to name the item you are creating the same as the texture and model file names as shown below. 
There are also no built-in texture and model files for this reason, and you will have to copy your own from the vanilla versions. 
You can find them easily at [mcasset.cloud](https://mcasset.cloud/).
```js
StartupEvents.registry("item", (event) => {
    event.create("crossbow", "crossbow");
});
```
![img.png](.github/assets/crossbow_models.png)![img_1.png](.github/assets/crossbow_textures.png)


### Future
Wolf armor cannot properly be done without mixin due to mojang hard coding it.

## Credits
All paxel code and tagging code from [Cucumber Library by BlakeBr0 under MIT license](https://github.com/BlakeBr0/Cucumber)

All built in textures provided by [FooterManDev](https://github.com/FooterManDev)