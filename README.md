# Starch Lib

An util library with no reflection.
Provides basic code for inventories, commands, ...

## Todo

 - [ ] Test objectlist for gui
 - [ ] Add comments

## Adding



<details>
<summary>Maven Artifact</summary>

```xml

<repository>
  <id>quinoaa-repository-public</id>
  <name>Quinoaa Repository</name>
  <url>https://maven.quinoaa.space/public</url>
</repository>

<dependency>
  <groupId>space.quinoaa</groupId>
  <artifactId>starch-lib</artifactId>
  <version>0.1</version>
</dependency>

```
</details>

<details>
<summary>Maven Shade</summary>

You should shade this artifact
```xml
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <createDependencyReducedPom>false</createDependencyReducedPom>
                        </configuration>
                    </execution>
                </executions>
                <configuration>
                    <artifactSet>
                        <includes>
                            <include>space.quinoaa:starch-lib</include>
                        </includes>
                    </artifactSet>
                        <filters>
                            <filter>
                                <artifact>*:*</artifact>
                                <excludes>
                                    <exclude>META-INF/**</exclude>
                                </excludes>
                            </filter>
                        </filters>
                    <relocations>
                        <relocation>
                            <pattern>space.quinoaa.starch</pattern>
                            <shadedPattern>[your package].starch</shadedPattern>
                        </relocation>
                    </relocations>
                </configuration>
            </plugin>
```
</details>


## Todo list
 - [ ] Add documentation
 - [ ] Add unit tests
 - [ ] Find improvements
 - [ ] Make this README.md look better
