# DouDiZhu Bukkit Plugin

A Bukkit plugin that simulates 100,000 rounds of the Chinese card game *DouDiZhu* (斗地主) and outputs the number of wins for the Landlord. Players can trigger the simulation by typing `ddz` in the chat.

---

## Features
- Simulates 100,000 rounds of *DouDiZhu* with a custom hand strength evaluation system.
- Outputs the number of Landlord wins in the chat.
- Easy to use: trigger the simulation with a single command (`ddz`).
- Customizable hand strength scoring system based on card values and combinations.

## Installation
1. Download the plugin JAR file from the [Releases](https://github.com/yourusername/your-repo/releases) page.
2. Place the JAR file in the `plugins` folder of your Bukkit/Spigot server.
3. Restart the server or use `/reload` to load the plugin.

## Usage
1. Join your Bukkit server as a player.
2. Type `ddz` in the chat and press Enter.
3. The plugin will simulate 100,000 rounds of *DouDiZhu* and display the number of Landlord wins in the chat.

**Note**: The simulation may take some time depending on your server's performance.

## Hand Strength Scoring System
The plugin uses a custom scoring system to evaluate hand strength, designed to reflect the strategic value of cards and combinations in *DouDiZhu*. The scoring rules are as follows:

### Single Card Values
- 3: 1 point
- 4: 2 points
- 5: 3 points
- 6: 4 points
- 7: 5 points
- 8: 6 points
- 9: 7 points
- 10: 8 points
- J: 9 points
- Q: 10 points
- K: 11 points
- A: 12 points
- 2: 15 points
- Black Joker: 18 points
- Red Joker: 20 points

### Card Combination Scoring
- **Bomb**: (Single card value × 5) + 20
- **Airplane**: (Sum of card values × 2) + 10
- **Three of a Kind**: Single card value × 3.5
- **Three with One**: Three of a kind score + (Attached card value × 0.5, or × 1 if attached card is 2 or Joker)
- **Three with Two**: Three of a kind score + (Attached pair value × 0.8, or × 1 if attached pair is a consecutive pair)
- **Straight**: Sum of card values + (Length × 2)
- **Consecutive Pairs**: Sum of card values + (Length × 3)
- **Single Card Penalty**: -2 points per uncombined single card

### Role Adjustments
- **Landlord**: Bomb and high-value cards (2, Jokers) scores are multiplied by 1.2.
- **Peasants**: Straight, consecutive pairs, and control cards (A, K) scores are multiplied by 1.1.

## Contributing
Contributions are welcome! If you have ideas for improving the simulation, scoring system, or adding new features, please:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For questions or suggestions, please open an issue on GitHub or contact the maintainer at [your-email@example.com].

---

# 斗地主 Bukkit 插件

一个 Bukkit 插件，用于模拟 100,000 轮中国扑克游戏 *斗地主*，并输出地主获胜的场次。玩家只需在聊天中输入 `ddz` 即可触发模拟。

---

## 功能
- 模拟 100,000 轮 *斗地主*，使用自定义的手牌强度评估系统。
- 在聊天中输出地主获胜的场次。
- 使用简单：通过单一命令 (`ddz`) 触发模拟。
- 基于牌值和组合的可定制手牌强度评分系统。

## 安装
1. 从 [Releases](https://github.com/yourusername/your-repo/releases) 页面下载插件的 JAR 文件。
2. 将 JAR 文件放入 Bukkit/Spigot 服务器的 `plugins` 文件夹。
3. 重启服务器或使用 `/reload` 命令加载插件。

## 使用方法
1. 以玩家身份加入你的 Bukkit 服务器。
2. 在聊天中输入 `ddz` 并按 Enter 键。
3. 插件将模拟 100,000 轮 *斗地主*，并在聊天中显示地主获胜的场次。

**注意**：模拟可能因服务器性能而耗时。

## 手牌强度评分系统
插件使用自定义评分系统来评估手牌强度，旨在反映 *斗地主* 中牌和组合的战略价值。评分规则如下：

### 单牌分值
- 3: 1 分
- 4: 2 分
- 5: 3 分
- 6: 4 分
- 7: 5 分
- 8: 6 分
- 9: 7 分
- 10: 8 分
- J: 9 分
- Q: 10 分
- K: 11 分
- A: 12 分
- 2: 15 分
- 小王: 18 分
- 大王: 20 分

### 牌型组合评分
- **炸弹**: (单牌分值 × 5) + 20
- **飞机**: (牌值总和 × 2) + 10
- **三张**: 单牌分值 × 3.5
- **三带一**: 三张分 + (附带牌分值 × 0.5，若附带牌为 2 或王则 × 1)
- **三带二**: 三张分 + (附带对牌分值 × 0.8，若为连对则 × 1)
- **顺子**: 牌值总和 + (长度 × 2)
- **连对**: 牌值总和 + (长度 × 3)
- **单牌惩罚**: 每张未组合的单牌 -2 分

### 角色调整
- **地主**: 炸弹和大牌（2、王牌）评分 × 1.2。
- **农民**: 顺子、连对和控制牌（A、K）评分 × 1.1。

## 贡献
欢迎贡献！如果你有改进模拟、评分系统或添加新功能的想法，请：
1. Fork 本仓库。
2. 创建新分支 (`git checkout -b feature/your-feature`)。
3. 提交更改 (`git commit -m 'Add your feature'`)。
4. 推送分支 (`git push origin feature/your-feature`)。
5. 提交 Pull Request。

## 许可证
本项目采用 MIT 许可证。详情见 [LICENSE](LICENSE) 文件。

## 联系方式
如有问题或建议，请在 GitHub 上提交 issue，或联系维护者：[your-email@example.com]。