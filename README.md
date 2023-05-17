# Starch Lib

An util library with ABSOLUTELY ZERO REFLECTION.

It's a spigot plugin library providing basic code for inventories, commands, ...
I got annoyed writing same code again.

## Maven

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
                    <relocations>
                        <relocation>
                            <pattern>space.quinoaa.starch</pattern>
                            <shadedPattern>[your package].starch</shadedPattern>
                        </relocation>
                    </relocations>
                </configuration>
            </plugin>
```


## Todo list
 - [ ] Add documentation
 - [ ] Add unit tests
 - [ ] Find improvements
 - [ ] Make this README.md look better
