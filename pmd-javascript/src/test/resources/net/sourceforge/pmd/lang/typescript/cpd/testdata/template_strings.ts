logger.info(`Running action on event: ${githubConfig.event.name} with mode: ${config.mode}`);

export default createStyleSheet`
    * {
        box-sizing: border-box;
    }
    ::selection {
        background: ${({ theme }) => theme.colors.status.infoDark};
        color: ${({ theme }) => theme.colors.status.neutral};
    }
    div, label, p, span {
        user-select: none;
    }
    html {
        height: 100%;
        -moz-osx-font-smoothing: grayscale;
        -webkit-font-smoothing: antialiased;
        text-rendering: optimizeLegibility;
    }
    body {
        background-color: ${({ theme }) => theme.colors.backgrounds.page};
        margin: 0;
        padding: 0;
        height: 100%;
        overflow: hidden;
        display: flex;
    }
`;
