/**
 * https://www.codewars.com/kata/58e24788e24ddee28e000053
 */

package k5.t04_SimpleAssemblerInterpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

enum Instruction {
    mov, inc, dec, jnz
}

record Command(Instruction ins, String reg, String arg) {
    static Command parse(String str) {
        final var tokens = str.split(" ");
        return switch (Instruction.valueOf(tokens[0])) {
            case mov -> new Command(Instruction.mov, tokens[1], tokens[2]);
            case inc -> new Command(Instruction.inc, tokens[1], null);
            case dec -> new Command(Instruction.dec, tokens[1], null);
            case jnz -> new Command(Instruction.jnz, tokens[1], tokens[2]);
        };
    }
}

public class SimpleAssembler {
    static int evalToken(String token, Map<String, Integer> regs) {
        return Character.isAlphabetic(token.charAt(0)) ? regs.get(token) : Integer.parseInt(token);
    }

    private static int updateContext(int cursor, Command[] commands, Map<String, Integer> regs) {
        final var c = commands[cursor];
        switch (c.ins()) {
            case mov -> regs.put(c.reg(), evalToken(c.arg(), regs));
            case inc -> regs.computeIfPresent(c.reg(), (k, v) -> v + 1);
            case dec -> regs.computeIfPresent(c.reg(), (k, v) -> v - 1);
            case jnz -> cursor += evalToken(c.reg(), regs) != 0 ? evalToken(c.arg(), regs) - 1 : 0;
        }
        return cursor + 1;
    }

    public static Map<String, Integer> interpret(String[] program) {
        final var commands = Arrays.stream(program)
                .map(Command::parse)
                .toArray(Command[]::new);
        final var regs = new HashMap<String, Integer>();

        for (var i = 0; i < commands.length; ) {
            i = updateContext(i, commands, regs);
        }
        return regs;
    }
}