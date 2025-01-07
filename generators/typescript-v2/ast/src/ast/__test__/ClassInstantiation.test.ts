import { ts } from "../..";

describe("ClassInstantiation", () => {
    describe("new Instantiation", () => {
        it("Should generate a new instantiation without arguments", () => {
            const actual = ts.instantiateClass({
                class_: ts.reference({ name: "TestClass" }),
                arguments_: []
            });
            expect(actual.toStringFormatted()).toMatchSnapshot();
        });
    });

    describe("new Instantiation with arguments", () => {
        it("Should generate a new instantiation with arguments", () => {
            const actual = ts.instantiateClass({
                class_: ts.reference({ name: "TestClass" }),
                arguments_: [ts.TypeLiteral.string("https://api.example.com")]
            });
            expect(actual.toStringFormatted()).toMatchSnapshot();
        });
    });

    describe("new Instantiation with 2 arguments", () => {
        it("Should generate a new instantiation with arguments", () => {
            const actual = ts.instantiateClass({
                class_: ts.reference({ name: "TestClass" }),
                arguments_: [
                    ts.TypeLiteral.string("https://api.example.com"),
                    ts.TypeLiteral.string("https://api.otherexample.com")
                ]
            });
            expect(actual.toStringFormatted()).toMatchSnapshot();
        });
    });
});
