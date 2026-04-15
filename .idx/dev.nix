# To learn more about how to use Nix to configure your environment
# see: https://developers.google.com/idx/guides/customize-idx-env
{ pkgs, ... }: {
  # Which nixpkgs channel to use.
  channel = "stable-24.05"; # or "unstable"

  # Use https://search.nixos.org/packages to find packages
  packages = [
    pkgs.jdk17
    pkgs.android-tools
    pkgs.gradle
  ];

  # Sets environment variables in the workspace
  env = { };
  idx = {
    # Search for the extensions you want on https://open-vsx.org/ and use "publisher.id"
    extensions = [
      "ms-ceintl.vscode-language-pack-ko" # Korean pack for user convenience
      "vscjava.vscode-java-pack"
      "doggy8088.vscode-kotlin"
    ];

    # Enable previews
    previews = {
      enable = true;
      previews = {
        android = {
          command = [ "gradle" ":app:assembleDebug" "-Pandroid.injected.invoked.from.ide=true" ];
          manager = "android";
        };
      };
    };

    # Workspace lifecycle hooks
    workspace = {
      # Runs when a workspace is first created
      onCreate = {
        # Generate gradle wrapper
        setup-wrapper = "gradle wrapper";
      };
      # Runs when a workspace is (re)started
      onStart = {
      };
    };

  };
}
